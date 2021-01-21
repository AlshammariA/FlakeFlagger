public void testNullTrueFalse(){
  JsopTokenizer t;
  t=new JsopTokenizer("null, 1, null, true, false");
  assertEquals(null,t.read(JsopReader.NULL));
  assertEquals(",",t.read(','));
  assertEquals("1",t.read(JsopReader.NUMBER));
  assertEquals(",",t.read(','));
  assertEquals(null,t.read(JsopReader.NULL));
  assertEquals(",",t.read(','));
  assertEquals("true",t.read(JsopReader.TRUE));
  assertEquals(",",t.read(','));
  assertEquals("false",t.read(JsopReader.FALSE));
  t=new JsopTokenizer("true, false");
  assertEquals("true",t.read(JsopReader.TRUE));
  assertEquals(",",t.read(','));
  assertEquals("false",t.read(JsopReader.FALSE));
  t=new JsopTokenizer("false, true");
  assertEquals("false",t.read(JsopReader.FALSE));
  assertEquals(",",t.read(','));
  assertEquals("true",t.read(JsopReader.TRUE));
}
