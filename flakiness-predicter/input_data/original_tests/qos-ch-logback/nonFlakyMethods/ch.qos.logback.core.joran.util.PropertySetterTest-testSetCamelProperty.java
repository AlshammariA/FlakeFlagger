@Test public void testSetCamelProperty(){
  setter.setProperty("camelCase","trot");
  assertEquals("trot",house.getCamelCase());
  setter.setProperty("camelCase","gh");
  assertEquals("gh",house.getCamelCase());
}
