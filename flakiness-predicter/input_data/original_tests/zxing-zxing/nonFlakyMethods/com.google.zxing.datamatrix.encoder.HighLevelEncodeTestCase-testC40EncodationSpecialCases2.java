@Test public void testC40EncodationSpecialCases2(){
  String visualized=encodeHighLevel("AIMAIMAIMAIMAIMAIMAI");
  assertEquals("230 91 11 91 11 91 11 91 11 91 11 91 11 254 66 74",visualized);
}
