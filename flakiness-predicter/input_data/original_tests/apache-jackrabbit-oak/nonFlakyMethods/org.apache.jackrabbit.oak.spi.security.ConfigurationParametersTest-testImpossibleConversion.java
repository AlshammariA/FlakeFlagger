@Test public void testImpossibleConversion(){
  Map<String,Object> map=new HashMap<String,Object>();
  map.put("string","v");
  map.put("obj",new TestObject("test"));
  map.put("int",10);
  ConfigurationParameters options=ConfigurationParameters.of(map);
  Map<String,Class> impossible=new HashMap<String,Class>();
  impossible.put("string",TestObject.class);
  impossible.put("string",Integer.class);
  impossible.put("string",Calendar.class);
  impossible.put("obj",Integer.class);
  impossible.put("int",TestObject.class);
  impossible.put("int",Calendar.class);
  for (  String key : impossible.keySet()) {
    try {
      options.getConfigValue(key,null,impossible.get(key));
      fail("Impossible conversion for " + key + " to "+ impossible.get(key));
    }
 catch (    IllegalArgumentException e) {
    }
  }
}
