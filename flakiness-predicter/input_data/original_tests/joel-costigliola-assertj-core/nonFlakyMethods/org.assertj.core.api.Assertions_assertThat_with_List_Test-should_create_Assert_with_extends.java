@Test public void should_create_Assert_with_extends(){
  Employee bill=new Employee("bill");
  Person billou=bill;
  List<Person> list1=newArrayList(billou);
  List<Employee> list2=newArrayList(bill);
  Assertions.assertThat(list1).isEqualTo(list2);
  Assertions.assertThat(list2).isEqualTo(list1);
}
