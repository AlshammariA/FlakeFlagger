@Test public void testRightPad(){
{
    FormatInfo fi=FormatInfo.valueOf("-40");
    FormatInfo witness=new FormatInfo();
    witness.setMin(40);
    witness.setLeftPad(false);
    assertEquals(witness,fi);
  }
{
    FormatInfo fi=FormatInfo.valueOf("-12.5");
    FormatInfo witness=new FormatInfo();
    witness.setMin(12);
    witness.setMax(5);
    witness.setLeftPad(false);
    assertEquals(witness,fi);
  }
{
    FormatInfo fi=FormatInfo.valueOf("-14.-5");
    FormatInfo witness=new FormatInfo();
    witness.setMin(14);
    witness.setMax(5);
    witness.setLeftPad(false);
    witness.setLeftTruncate(false);
    assertEquals(witness,fi);
  }
}
