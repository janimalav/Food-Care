String[] COUNTRIES = new String[] {"Item 1", "Item 2", "Item 3", "Item 4"};

        ArrayAdapter<String> adapter =
        new ArrayAdapter<>(
        getContext(),
        R.layout.dropdown_menu_popup_item,
        COUNTRIES);

        AutoCompleteTextView editTextFilledExposedDropdown =
        view.findViewById(R.id.filled_exposed_dropdown);
        editTextFilledExposedDropdown.setAdapter(adapter);