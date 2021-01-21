@Test public void testNotEqual(){
  List<Restriction> rs=new ArrayList<Restriction>();
  rs.add(new RestrictionImpl(PropertyStates.createProperty(name,value,Type.STRING),true));
  rs.add(new RestrictionImpl(PropertyStates.createProperty(name,ImmutableList.of(value),Type.NAMES),true));
  rs.add(new RestrictionImpl(createProperty("otherName",value),true));
  rs.add(new RestrictionImpl(createProperty("name","otherValue"),true));
  rs.add(new RestrictionImpl(createProperty(name,value),false));
  rs.add(new Restriction(){
    @Nonnull @Override public RestrictionDefinition getDefinition(){
      return new RestrictionDefinitionImpl(name,Type.NAME,true);
    }
    @Override public PropertyState getProperty(){
      return createProperty(name,value);
    }
  }
);
  for (  Restriction r : rs) {
    assertFalse(restriction.equals(r));
  }
}
