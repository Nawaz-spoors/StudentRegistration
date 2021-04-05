package business;

import dao.AdminDao;

public class AdminBoImpl implements AdminBo {
	AdminDao dao;
	public AdminDao getDao() {
		return dao;
	}
	public void setDao(AdminDao dao) {
		this.dao = dao;
	}
	public boolean findByName(String name,String pwd) {
		// TODO Auto-generated method stub
		
		return pwd.equals(dao.authenticateByName(name));
	}

}
