@Test public void testBasic(){
{
    FormatInfo fi=FormatInfo.valueOf("45");
    FormatInfo witness=new FormatInfo();
    witness.setMin(45);
    assertEquals(witness,fi);
  }
{
    FormatInfo fi=FormatInfo.valueOf("4.5");
    FormatInfo witness=new FormatInfo();
    witness.setMin(4);
    witness.setMax(5);
    assertEquals(witness,fi);
  }
}
