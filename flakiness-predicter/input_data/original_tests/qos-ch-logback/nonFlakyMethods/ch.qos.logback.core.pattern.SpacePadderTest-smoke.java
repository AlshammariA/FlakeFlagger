@Test public void smoke(){
{
    StringBuilder buf=new StringBuilder();
    String s="a";
    SpacePadder.leftPad(buf,s,4);
    assertEquals("   a",buf.toString());
  }
{
    StringBuilder buf=new StringBuilder();
    String s="a";
    SpacePadder.rightPad(buf,s,4);
    assertEquals("a   ",buf.toString());
  }
}
