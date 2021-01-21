@Test public void testSplit(){
  assertEquals(3,TypeCodes.split("str:foo"));
  assertEquals(3,TypeCodes.split("str:"));
  assertEquals(-1,TypeCodes.split("foo"));
  assertEquals(-1,TypeCodes.split(""));
}
