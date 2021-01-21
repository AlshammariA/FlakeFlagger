@Test public void should_pass_if_actual_contains_given_values_only_once_even_if_actual_type_is_not_comparable(){
  Rectangle r1=new Rectangle(1,1);
  Rectangle r2=new Rectangle(2,2);
  iterables.assertContainsOnlyOnce(someInfo(),newArrayList(r1,r2,r2),array(r1));
}
