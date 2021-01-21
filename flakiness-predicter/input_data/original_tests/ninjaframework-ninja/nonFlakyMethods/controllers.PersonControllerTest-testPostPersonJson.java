@Test public void testPostPersonJson() throws Exception {
  Person person=new Person();
  person.name="zeeess name - and some utf8 => öäü";
  String response=ninjaTestBrowser.postJson(getServerAddress() + "api/person.json",person);
  System.out.println("j: " + response);
  Person result=new ObjectMapper().readValue(response,Person.class);
  assertEquals(person.name,result.name);
}
