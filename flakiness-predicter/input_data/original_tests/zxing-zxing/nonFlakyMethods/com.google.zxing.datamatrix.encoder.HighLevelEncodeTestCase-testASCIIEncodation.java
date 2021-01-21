@Test public void testASCIIEncodation(){
  String visualized=encodeHighLevel("123456");
  assertEquals("142 164 186",visualized);
  visualized=encodeHighLevel("123456£");
  assertEquals("142 164 186 235 36",visualized);
  visualized=encodeHighLevel("30Q324343430794<OQQ");
  assertEquals("160 82 162 173 173 173 137 224 61 80 82 82",visualized);
}
