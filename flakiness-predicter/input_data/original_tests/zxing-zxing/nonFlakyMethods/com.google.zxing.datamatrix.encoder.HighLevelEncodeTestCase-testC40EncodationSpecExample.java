@Test public void testC40EncodationSpecExample(){
  String visualized=encodeHighLevel("A1B2C3D4E5F6G7H8I9J0K1L2");
  assertEquals("230 88 88 40 8 107 147 59 67 126 206 78 126 144 121 35 47 254",visualized);
}
