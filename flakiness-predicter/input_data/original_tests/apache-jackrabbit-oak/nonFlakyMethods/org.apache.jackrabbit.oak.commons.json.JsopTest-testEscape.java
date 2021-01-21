public void testEscape(){
  assertEquals("null",JsopBuilder.encode(null));
  JsopBuilder buff=new JsopBuilder().key("back\\slash").value("\\").key("back\\\\slash").value("\\\\");
  assertEquals("\"back\\\\slash\":\"\\\\\",\"back\\\\\\\\slash\":\"\\\\\\\\\"",buff.toString());
}
