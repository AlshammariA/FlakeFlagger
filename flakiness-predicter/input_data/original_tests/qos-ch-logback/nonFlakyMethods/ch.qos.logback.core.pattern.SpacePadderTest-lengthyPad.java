@Test public void lengthyPad(){
{
    StringBuilder buf=new StringBuilder();
    String s="abc";
    SpacePadder.leftPad(buf,s,33);
    assertEquals("                              abc",buf.toString());
  }
{
    StringBuilder buf=new StringBuilder();
    String s="abc";
    SpacePadder.rightPad(buf,s,33);
    assertEquals("abc                              ",buf.toString());
  }
}
