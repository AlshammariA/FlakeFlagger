public void testNumber(){
  JsopTokenizer t=new JsopTokenizer("9/3:-3-:-/- 3");
  assertEquals("9",t.read(JsopReader.NUMBER));
  t.read('/');
  assertEquals("3",t.read(JsopReader.NUMBER));
  t.read(':');
  assertEquals("-3",t.read(JsopReader.NUMBER));
  t.read('-');
  t.read(':');
  t.read('-');
  t.read('/');
  t.read('-');
  t.read(JsopReader.NUMBER);
}
