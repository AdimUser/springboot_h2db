package hello;

public class Greeting {

    private long id;
    private String Name;
    
    public Greeting() {
    	super();
	}

    public Greeting(long id, String Name) {
    	super();
    	this.id = id;
        this.Name = Name;
	}
    
    public Greeting(long id) {
    	super();
    	this.id = id;
	}

	public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
    
    @Override
    public String toString() {
        return String.format("User [id=%s, Name=%s]", id, Name);
    }

}