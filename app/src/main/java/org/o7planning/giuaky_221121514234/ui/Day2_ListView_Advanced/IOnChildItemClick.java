package org.o7planning.giuaky_221121514234.ui.Day2_ListView_Advanced;

import org.o7planning.giuaky_221121514234.ui.Day2_ListView.ContactModel;

public interface IOnChildItemClick {
    void onItemChildClick(int position);
    void onCallClick(ContactModel contact);
    void onEditClick(ContactModel contact);
}
