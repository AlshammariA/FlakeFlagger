@Test public void nullString(){
  String s=null;
{
    StringBuilder buf=new StringBuilder();
    SpacePadder.leftPad(buf,s,2);
    assertEquals("  ",buf.toString());
  }
{
    StringBuilder buf=new StringBuilder();
    SpacePadder.rightPad(buf,s,2);
    assertEquals("  ",buf.toString());
  }
}
