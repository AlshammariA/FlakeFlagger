@Test public void testFileSize(){
  setter.setProperty("fs","2 kb");
  assertEquals(2 * 1024,house.getFs().getSize());
}
