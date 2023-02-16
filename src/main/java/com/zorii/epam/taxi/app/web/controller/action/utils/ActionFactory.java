package com.zorii.epam.taxi.app.web.controller.action.utils;

import com.zorii.epam.taxi.app.web.controller.action.*;

import java.util.HashMap;
import java.util.Map;

import static com.zorii.epam.taxi.app.web.controller.constant.Actions.*;

public class ActionFactory {
    private static ActionFactory actionFactory;
    private static final Map<String, Action> ACTION_MENU= new HashMap<>();

    public static ActionFactory getInstance() {
        if (actionFactory == null)
            actionFactory = new ActionFactory();

        return actionFactory;
    }
    private ActionFactory(){}


    static {
        ACTION_MENU.put(SIGN_UP_ACTION, new SignUpAction());
        ACTION_MENU.put(SIGN_IN_ACTION, new SignInAction());
        ACTION_MENU.put(LOG_OUT_ACTION, new LogOutAction());
        ACTION_MENU.put(EDIT_PROFILE_ACTION, new EditProfileAction());
        ACTION_MENU.put(PREPARE_CATEGORIES_ACTION, new PrepareCategoriesAction());
        ACTION_MENU.put(CALCULATE_PRICE_ACTION, new CalculatePriceAction());
        ACTION_MENU.put(MAKE_ORDER_ACTION, new MakeOrderAction());
        ACTION_MENU.put(DISPLAY_ORDERS, new DisplayOrdersAction());
    }

    public Action getAction(String action){
        return ACTION_MENU.get(action);
    }

}
