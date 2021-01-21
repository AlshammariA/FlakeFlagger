@Test public void test(){
{
    FileSize fs=FileSize.valueOf("8");
    assertEquals(8,fs.getSize());
  }
{
    FileSize fs=FileSize.valueOf("8 kbs");
    assertEquals(8 * KB_CO,fs.getSize());
  }
{
    FileSize fs=FileSize.valueOf("8 kb");
    assertEquals(8 * KB_CO,fs.getSize());
  }
{
    FileSize fs=FileSize.valueOf("12 mb");
    assertEquals(12 * MB_CO,fs.getSize());
  }
{
    FileSize fs=FileSize.valueOf("5 GBs");
    assertEquals(5 * GB_CO,fs.getSize());
  }
}
