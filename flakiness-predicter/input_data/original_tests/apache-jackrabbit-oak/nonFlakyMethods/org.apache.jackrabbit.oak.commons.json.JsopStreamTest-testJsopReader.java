public void testJsopReader(){
  JsopStream s=new JsopStream().tag('+').key("x").object().key("y").value(1).key("n").value("").key("z").encodedValue("n10").endObject();
  s.setLineLength(-1);
  assertEquals("+\"x\":{\"y\":1,\"n\":\"\",\"z\":n10}",s.toString());
  assertFalse(s.matches('-'));
  assertTrue(s.matches('+'));
  assertEquals("x",s.read(JsopReader.STRING));
  try {
    s.read('}');
    fail();
  }
 catch (  Exception e) {
  }
  s.read(':');
  assertEquals("{",s.read('{'));
  assertEquals("y",s.readString());
  s.read(':');
  assertEquals("1",s.readRawValue());
  s.read(',');
  assertEquals("n",s.readString());
  s.read(':');
  assertEquals("\"\"",s.readRawValue());
  s.read(',');
  assertEquals("z",s.readString());
  s.read(':');
  assertEquals("n10",s.readRawValue());
  s.read('}');
}
