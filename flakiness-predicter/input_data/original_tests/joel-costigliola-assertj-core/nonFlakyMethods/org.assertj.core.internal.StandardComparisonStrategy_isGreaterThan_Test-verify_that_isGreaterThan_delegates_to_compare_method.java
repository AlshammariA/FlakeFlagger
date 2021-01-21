@Test public void verify_that_isGreaterThan_delegates_to_compare_method(){
  Employee boss=mock(Employee.class);
  Employee young=new Employee(10000,25);
  standardComparisonStrategy.isGreaterThan(boss,young);
  verify(boss).compareTo(young);
}
