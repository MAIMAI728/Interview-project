package models.entities;

public enum Topic{
	JAVA(1),
	SQL(2);
	
	public int id;
	
	Topic(int id){
		this.id=id;
	}
	
//	TYPE1("JAVA"),
//	TYPE2("SQL");
//	
//	private final String topic;
//
//    private Topic(final String topic) {
//        this.topic = topic;
//    }
//
//    public String getString() {
//        return this.topic;
//    }
}

