package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public boolean regist(User user) {
        User u = dao.findByUserName(user.getUsername());
        if (u != null) {
            return false;
            //用户名存在  注册失败
        }
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");
        dao.save(user);
        String content = "<a href='http://localhost/travel/activeUserServlet?code=" + user.getCode() + "'>点击激活【黑马旅游网】</a>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮件");
        return true;
    }

    @Override
    public boolean active(String code) {
        User user = dao.findByCode(code);
        if (user != null) {
            dao.updateStatus(user);
            return true;
        } else {

            return false;
        }
    }

    @Override
    public User login(User user) {
        User u = dao.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        return u;
    }
}
