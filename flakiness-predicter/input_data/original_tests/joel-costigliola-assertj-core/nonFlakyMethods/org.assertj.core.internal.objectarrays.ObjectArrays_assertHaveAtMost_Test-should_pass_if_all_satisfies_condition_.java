@Test public void should_pass_if_all_satisfies_condition_(){
  actual=array("Chewbacca","Leia","Obiwan");
  arrays.assertHaveAtMost(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
