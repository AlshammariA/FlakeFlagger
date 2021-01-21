@Test public void testMinOnly(){
{
    FormatInfo fi=FormatInfo.valueOf("49");
    FormatInfo witness=new FormatInfo();
    witness.setMin(49);
    assertEquals(witness,fi);
  }
{
    FormatInfo fi=FormatInfo.valueOf("-587");
    FormatInfo witness=new FormatInfo();
    witness.setMin(587);
    witness.setLeftPad(false);
    assertEquals(witness,fi);
  }
}
