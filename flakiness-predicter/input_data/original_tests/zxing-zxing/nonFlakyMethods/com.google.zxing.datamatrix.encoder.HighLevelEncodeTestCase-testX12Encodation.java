@Test public void testX12Encodation(){
  String visualized=encodeHighLevel("ABC>ABC123>AB");
  assertEquals("238 89 233 14 192 100 207 44 31 67",visualized);
  visualized=encodeHighLevel("ABC>ABC123>ABC");
  assertEquals("238 89 233 14 192 100 207 44 31 254 67 68",visualized);
  visualized=encodeHighLevel("ABC>ABC123>ABCD");
  assertEquals("238 89 233 14 192 100 207 44 31 96 82 254",visualized);
  visualized=encodeHighLevel("ABC>ABC123>ABCDE");
  assertEquals("238 89 233 14 192 100 207 44 31 96 82 70",visualized);
  visualized=encodeHighLevel("ABC>ABC123>ABCDEF");
  assertEquals("238 89 233 14 192 100 207 44 31 96 82 254 70 71 129 237",visualized);
}
