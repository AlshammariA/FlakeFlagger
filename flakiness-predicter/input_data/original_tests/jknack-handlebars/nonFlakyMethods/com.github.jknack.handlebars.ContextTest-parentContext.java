@Test public void parentContext(){
  Map<String,Object> model=new HashMap<String,Object>();
  model.put("name","Handlebars");
  Context parent=Context.newContext(model);
  assertNotNull(parent);
  assertEquals("Handlebars",parent.get("name"));
  Map<String,Object> extended=new HashMap<String,Object>();
  extended.put("n","Extended");
  Context child=Context.newContext(parent,extended);
  assertEquals("Extended",child.get("n"));
  assertEquals("Handlebars",child.get("name"));
}
