@Test public void testPropertyCollection(){
  setter.addBasicProperty("adjective","nice");
  setter.addBasicProperty("adjective","big");
  assertEquals(2,house.adjectiveList.size());
  assertEquals("nice",house.adjectiveList.get(0));
  assertEquals("big",house.adjectiveList.get(1));
}
