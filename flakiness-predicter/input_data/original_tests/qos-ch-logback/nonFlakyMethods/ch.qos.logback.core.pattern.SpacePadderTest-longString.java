@Test public void longString(){
{
    StringBuilder buf=new StringBuilder();
    String s="abc";
    SpacePadder.leftPad(buf,s,2);
    assertEquals(s,buf.toString());
  }
{
    StringBuilder buf=new StringBuilder();
    String s="abc";
    SpacePadder.rightPad(buf,s,2);
    assertEquals(s,buf.toString());
  }
}
