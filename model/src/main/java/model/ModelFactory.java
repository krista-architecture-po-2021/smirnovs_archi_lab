package model;

import dao.DAOCategory;
import dao.DAONews;

public abstract class ModelFactory {
        public abstract DAONews getNewsDAO(int value);
        public  abstract DAOCategory getCategoryDAO(int value);

        public static ModelFactory getModel(){
            return new FormatModel();
        }

}
