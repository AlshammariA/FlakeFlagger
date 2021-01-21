@Test public void testMaxOnly(){
{
    FormatInfo fi=FormatInfo.valueOf(".49");
    FormatInfo witness=new FormatInfo();
    witness.setMax(49);
    assertEquals(witness,fi);
  }
{
    FormatInfo fi=FormatInfo.valueOf(".-5");
    FormatInfo witness=new FormatInfo();
    witness.setMax(5);
    witness.setLeftTruncate(false);
    assertEquals(witness,fi);
  }
}
