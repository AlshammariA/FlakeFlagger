public void testAddStatus(){
{
    InfoStatus status=new InfoStatus("testing",this);
    status.add(new ErrorStatus("error",this));
    Iterator it=status.iterator();
    assertTrue("No status was added",it.hasNext());
    assertTrue("hasChilden method reported wrong result",status.hasChildren());
  }
{
    InfoStatus status=new InfoStatus("testing",this);
    try {
      status.add(null);
      fail("method should have thrown an Exception");
    }
 catch (    NullPointerException ex) {
    }
  }
}
