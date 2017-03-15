package controller.UserController;

import dao.CardDAO;
import dao.ChargeLogDAO;
import dao.ClassDAO;
import dao.ClassMemberDAO;
import model.CardEntity;
import model.ChargeLogEntity;
import model.ClassEntity;
import model.ClassMemberEntity;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.ClassService;
import utility.CardHelper;
import utility.DateHelper;
import utility.DiscountHelper;
import utility.LogHelper;
import vo.member.BookingVO;

import javax.servlet.http.HttpSession;
import javax.smartcardio.Card;
import java.util.List;

/**
 * Created by cdn on 17/3/10.
 */
@Controller
public class BookingController {

    @Autowired
    ClassService classService;
    @Autowired
    ClassMemberDAO classMemberDAO;
    @Autowired
    CardDAO cardDAO;
    @Autowired
    ChargeLogDAO chargeLogDAO;
    @Autowired
    ClassDAO classDAO;

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public String getBooking(HttpSession session, ModelMap model) {
        int cardId = CardHelper.getCurrentCardId(session);
        List<BookingVO> vos = classService.getBookings(cardId);
        JSONArray bookings = new JSONArray();

        for (BookingVO vo : vos){
            JSONObject obj = new JSONObject();
            obj.put("id",vo.id);
            obj.put("name",vo.name);
            obj.put("price",vo.price);
            obj.put("memberNum",vo.memberNum);
            obj.put("learn_time",vo.learn_time);
            obj.put("orgName",vo.orgName);
            obj.put("start_time", DateHelper.getDate(vo.start_time));
            obj.put("leftMembers",vo.leftMembers);

            bookings.add(obj);
        }

        model.addAttribute("bookings",bookings);

        return "member/booking";
    }

    @RequestMapping(value = "/bookCourse", method = RequestMethod.GET)
    public String bookCourse(@RequestParam("id") int id, HttpSession session) {

        int cardId = CardHelper.getCurrentCardId(session);
        CardEntity cardEntity = cardDAO.findOne(cardId);
        ClassEntity classEntity = classDAO.findOne(id);
        ClassMemberEntity cm = LogHelper.getBookCM(cardId,id);
        double discount = DiscountHelper.getDiscount(cardEntity.getLevel());

        int consume = (int)(classEntity.getPrice()*discount);
        int leftMember = classEntity.getLeftMembers() - 1;

        cardDAO.updateCardBalance(cardEntity.getBalance() - consume,cardId);
        classDAO.updateClassLeftMember(leftMember,id);

        cardEntity = cardDAO.findOne(cardId);
        classEntity = classDAO.findOne(id);
        ChargeLogEntity chargeLog = LogHelper.getBookChargeLog(cardEntity,classEntity,consume);

        classMemberDAO.save(cm);
        chargeLogDAO.save(chargeLog);

        return "redirect:/booking";
    }

    @RequestMapping(value = "/unbookCourse", method = RequestMethod.GET)
    public String unbookCourse(@RequestParam("id") int id, HttpSession session) {

        int cardId = CardHelper.getCurrentCardId(session);
        CardEntity cardEntity = cardDAO.findOne(cardId);
        ClassEntity classEntity = classDAO.findOne(id);
        ClassMemberEntity cm = LogHelper.getUnbookCM(cardId,id);

        List<ChargeLogEntity> chs = chargeLogDAO.findByCardIdOrderByTimeDesc(cardEntity);
        ChargeLogEntity ch = DiscountHelper.getBookChargeLog(chs,id);

        int consume = ch.getMoney();

        cardDAO.updateCardBalance(cardEntity.getBalance() + (int)(consume*0.9),cardId);
        int leftMember = classEntity.getLeftMembers() + 1;
        classDAO.updateClassLeftMember(leftMember,id);

        classEntity = classDAO.findOne(id);
        cardEntity = cardDAO.findOne(cardId);
        ChargeLogEntity chargeLog = LogHelper.getUnbookChargeLog(cardEntity,classEntity);

        classMemberDAO.save(cm);
        chargeLogDAO.save(chargeLog);

        return "redirect:/booking";
    }


}
