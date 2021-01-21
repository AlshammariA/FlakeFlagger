@Test public void testBase256Encodation(){
  String visualized=encodeHighLevel("\u00ABäöüé\u00BB");
  assertEquals("231 44 108 59 226 126 1 104",visualized);
  visualized=encodeHighLevel("\u00ABäöüéà\u00BB");
  assertEquals("231 51 108 59 226 126 1 141 254 129",visualized);
  visualized=encodeHighLevel("\u00ABäöüéàá\u00BB");
  assertEquals("231 44 108 59 226 126 1 141 36 147",visualized);
  visualized=encodeHighLevel(" 23£");
  assertEquals("33 153 235 36 129",visualized);
  visualized=encodeHighLevel("\u00ABäöüé\u00BB 234");
  assertEquals("231 51 108 59 226 126 1 104 99 153 53 129",visualized);
  visualized=encodeHighLevel("\u00ABäöüé\u00BB 23£ 1234567890123456789");
  assertEquals("231 55 108 59 226 126 1 104 99 10 161 167 185 142 164 186 208" + " 220 142 164 186 208 58 129 59 209 104 254 150 45",visualized);
  visualized=encodeHighLevel(createBinaryMessage(20));
  assertEquals("231 44 108 59 226 126 1 141 36 5 37 187 80 230 123 17 166 60 210 103 253 150",visualized);
  visualized=encodeHighLevel(createBinaryMessage(19));
  assertEquals("231 63 108 59 226 126 1 141 36 5 37 187 80 230 123 17 166 60 210 103 1 129",visualized);
  visualized=encodeHighLevel(createBinaryMessage(276));
  assertStartsWith("231 38 219 2 208 120 20 150 35",visualized);
  assertEndsWith("146 40 194 129",visualized);
  visualized=encodeHighLevel(createBinaryMessage(277));
  assertStartsWith("231 38 220 2 208 120 20 150 35",visualized);
  assertEndsWith("146 40 190 87",visualized);
}
