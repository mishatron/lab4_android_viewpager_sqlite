package lab4.lab.com.lab4.pages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import lab4.lab.com.lab4.R;
import lab4.lab.com.lab4.db.Note;

public class NotesAdapter extends BaseAdapter {

    private Context ctx;
    private LayoutInflater lInflater;
    private ArrayList<Note> objects;

    NotesAdapter(Context context, ArrayList<Note> products) {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // кол-во элементов
    @Override
    public int getCount() {
        return objects.size();
    }

    // элемент по позиции
    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    // id по позиции
    @Override
    public long getItemId(int position) {
        return position;
    }

    // пункт списка
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null) {
            view = lInflater.inflate(R.layout.item_note, parent, false);
        }

        Note p = getProduct(position);

        // заполняем View в пункте списка данными из товаров: наименование, цена
        // и картинка
        ((TextView) view.findViewById(R.id.text_id)).setText(p.getId()+"");
        ((TextView) view.findViewById(R.id.text_note)).setText(p.getText());
        return view;
    }

    // товар по позиции
    private Note getProduct(int position) {
        return ((Note) getItem(position));
    }


}
