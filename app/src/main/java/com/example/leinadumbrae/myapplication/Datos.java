package com.example.leinadumbrae.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class Datos implements Parcelable {

    String nombre;
    String interes;
    String sexo;                        //pues ya saben, la misma verga que en estructura de datos, es lo mismo, les recomiendo que lo hagan automatico
    public  Datos()
    {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInteres() {
        return interes;
    }

    public void setInteres(String interes) {
        this.interes = interes;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Datos(String nombre, String sexo, String interes) {
        this.nombre = nombre;
        this.interes = interes;
        this.sexo = sexo;
    }


    // de aqui para abajo no es necesario (ponerlo en caso de que si lo pida) era por que lo queria hacer parcelable el objeto
    @Override
    public String toString() {
        return nombre+" "+sexo+" "+interes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nombre);
        dest.writeString(this.interes);
        dest.writeString(this.sexo);
    }

    protected Datos(Parcel in) {
        this.nombre = in.readString();
        this.interes = in.readString();
        this.sexo = in.readString();
    }

    public static final Parcelable.Creator<Datos> CREATOR = new Parcelable.Creator<Datos>() {
        @Override
        public Datos createFromParcel(Parcel source) {
            return new Datos(source);
        }

        @Override
        public Datos[] newArray(int size) {
            return new Datos[size];
        }
    };
}
                                         //ya cumpli con mi parte    :)