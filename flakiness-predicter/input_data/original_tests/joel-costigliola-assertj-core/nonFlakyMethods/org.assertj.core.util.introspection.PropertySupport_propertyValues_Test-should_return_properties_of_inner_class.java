@Test public void should_return_properties_of_inner_class(){
  VehicleFactory vehicleFactory=new VehicleFactory();
  List<String> names=PropertySupport.instance().propertyValues("name",String.class,vehicleFactory.getVehicles());
  assertThat(names).containsExactly("Toyota","Honda","Audi");
}
