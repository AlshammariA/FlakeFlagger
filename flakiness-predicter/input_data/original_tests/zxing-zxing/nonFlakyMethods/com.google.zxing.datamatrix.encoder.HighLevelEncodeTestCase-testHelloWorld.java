@Test public void testHelloWorld(){
  String visualized=encodeHighLevel("Hello World!");
  assertEquals("73 239 116 130 175 123 148 64 158 233 254 34",visualized);
}
