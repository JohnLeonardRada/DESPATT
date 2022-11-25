       
    }

    public void testOGNL() throws Exception {
        
        OgnlRuntime.setPropertyAccessor(DynaBean.class, new DynaBeanPropertyAccessor());

        assertTrue("This is a string".equals(Ognl.getValue("stringProperty", bean)));

    }


    /**
     * Create and return a <code>DynaClass</code> instance for our test
     * <code>DynaBean</code>.
     */
    protected DynaClass createDynaClass() {

        int intArray[] = new int[0];
        String stringArray[] = new String[0];

        DynaClass dynaClass = new BasicDynaClass
                ("TestDynaClass", null,
                        new DynaProperty[]{
                            new DynaProperty("booleanProperty", Boolean.TYPE),
                            new DynaProperty("booleanSecond", Boolean.TYPE),
                            new DynaProperty("doubleProperty