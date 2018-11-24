package messgeclient;


public abstract class ServiceLinkDB {
	public void ServiceLinkDB() {
		String host,user,passwd,dbname,table,charset,dbtype;
		int prot;		
	}
	public abstract void linkdb();		
	public abstract void readdb(); 		
	public abstract void writedb(); 
	public abstract void createdb(); 
	public abstract void deletedb(); 

}
class ServiceLinkMysqlDB extends ServiceLinkDB {
	
	public void ServiceLinkDB() {	
	}
	@Override
	public void linkdb(){
		
	}		
	public void textlinkdb(){
		
	}		
	@Override
	public void readdb(){
	
	}
	@Override
	public void writedb(){
	
	}
	@Override
	public void createdb() {
		// TODO 自动生成的方法存根
		
	}
	@Override
	public void deletedb() {
		// TODO 自动生成的方法存根
		
	}
}

