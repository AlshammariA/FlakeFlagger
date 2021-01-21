@Test public void testPostPersonXml() throws Exception {
  Person person=new Person();
  person.name="zeeess name - and some utf8 => öäü";
  String response=ninjaTestBrowser.postXml(getServerAddress() + "api/person.xml",person);
  System.out.println("j: " + response);
  Person result=new XmlMapper().readValue(response,Person.class);
  assertEquals(person.name,result.name);
}
