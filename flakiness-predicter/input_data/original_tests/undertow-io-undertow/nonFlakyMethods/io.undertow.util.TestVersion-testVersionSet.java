@Test public void testVersionSet(){
  Assert.assertNotNull(Version.getVersionString());
  String version=Version.getVersionString();
  System.out.println("version = " + version);
  Assert.assertNotSame("Unknown",version);
}
