@Test public void should_pass_if_each_element_satisfies_condition(){
  actual=array("Solo","Leia");
  arrays.assertDoNotHave(someInfo(),actual,jediPower);
}
