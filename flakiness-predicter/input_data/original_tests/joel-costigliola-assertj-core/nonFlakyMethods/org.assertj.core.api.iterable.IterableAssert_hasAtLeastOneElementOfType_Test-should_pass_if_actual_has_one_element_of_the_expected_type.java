@Test public void should_pass_if_actual_has_one_element_of_the_expected_type(){
  List<Object> list=newArrayList();
  list.add("string");
  list.add(1);
  assertThat(list).hasAtLeastOneElementOfType(Integer.class).hasAtLeastOneElementOfType(String.class).hasAtLeastOneElementOfType(Object.class);
}
