package com.example.noticias_uteq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class NoticiasAdapter extends RecyclerView.Adapter<NoticiasAdapter.NoticiaViewHolder> {

    private List<Noticia> noticiasList;
    private Context context;

    // Constructor para recibir los datos y el contexto
    public NoticiasAdapter(Context context, List<Noticia> noticiasList) {
        this.context = context;
        this.noticiasList = noticiasList;
    }

    // Este método crea una nueva vista para cada item de la lista
    @NonNull
    @Override
    public NoticiaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout 'item_noticia.xml' que diseñamos
        View view = LayoutInflater.from(context).inflate(R.layout.item_noticia, parent, false);
        return new NoticiaViewHolder(view);
    }

    // Este método conecta los datos de una noticia con la vista
    @Override
    public void onBindViewHolder(@NonNull NoticiaViewHolder holder, int position) {
        // Obtenemos la noticia de la posición actual
        Noticia noticia = noticiasList.get(position);

        // Asignamos los datos a los componentes visuales
        holder.tvTitulo.setText(noticia.getTitular());
        holder.tvFecha.setText("Publicada el: " + noticia.getFecha());

        // --- Aquí ocurre la CONCATENACIÓN para la IMAGEN ---
        String urlCompletaImagen = "https://uteq.edu.ec/assets/images/news/pagina/" + noticia.getUrlPortadaParcial();
        // Usamos la librería Glide para cargar la imagen desde la URL en el ImageView
        Glide.with(context)
                .load(urlCompletaImagen)
                .into(holder.ivPortada);

        // --- Aquí ocurre la CONCATENACIÓN para el ENLACE ---
        String urlCompletaNoticia = "https://uteq.edu.ec/es/comunicacion/noticia/" + noticia.getUrlNoticiaParcial();
        // Asignamos la URL completa al TextView del enlace
        holder.tvEnlace.setText(urlCompletaNoticia);
    }

    // Devuelve el número total de items en la lista
    @Override
    public int getItemCount() {
        return noticiasList.size();
    }

    // Esta clase interna representa los componentes de la vista de cada fila
    public static class NoticiaViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvFecha, tvEnlace; // 'tvEnlace' está incluido
        ImageView ivPortada;

        public NoticiaViewHolder(@NonNull View itemView) {
            super(itemView);
            // Enlazamos las variables con los IDs del layout 'item_noticia.xml'
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            ivPortada = itemView.findViewById(R.id.ivPortada);
            tvEnlace = itemView.findViewById(R.id.tvEnlace); // Referencia al nuevo TextView
        }
    }
}