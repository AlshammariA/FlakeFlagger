public void testRemoveStatus(){
{
    InfoStatus status=new InfoStatus("testing",this);
    ErrorStatus error=new ErrorStatus("error",this);
    status.add(error);
    boolean result=status.remove(error);
    Iterator it=status.iterator();
    assertTrue("Remove failed",result);
    assertFalse("No status was removed",it.hasNext());
    assertFalse("hasChilden method reported wrong result",status.hasChildren());
  }
{
    InfoStatus status=new InfoStatus("testing",this);
    ErrorStatus error=new ErrorStatus("error",this);
    status.add(error);
    boolean result=status.remove(null);
    assertFalse("Remove result was not false",result);
  }
}
