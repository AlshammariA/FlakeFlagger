public void testLineLength(){
  JsopBuilder buff=new JsopBuilder();
  buff.key("hello").value("world");
  assertEquals("\"hello\":\"world\"",buff.toString());
  assertEquals(15,buff.length());
  buff=new JsopBuilder();
  buff.setLineLength(10);
  buff.key("hello").value("world");
  assertEquals("\"hello\":\n\"world\"",buff.toString());
  assertEquals(16,buff.length());
}
